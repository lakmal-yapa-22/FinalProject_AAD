package com.example.backend.service;


import com.example.backend.entity.Message;
import com.example.backend.entity.MessageType;
import com.example.backend.repo.MessageRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class MessageService {

    @Value("${app.file.upload-dir}")
    private String uploadDir;

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getRecentMessages() {
        List<Message> messages = messageRepository.findTop50ByOrderByTimestampDesc();
        Collections.reverse(messages);
        return messages;
    }

    public Message saveTextMessage(String sender, String content) {
        Message message = new Message();
        message.setSender(sender);
        message.setContent(content);
        message.setType(MessageType.TEXT);
        return messageRepository.save(message);
    }

    public Message saveImageMessage(String sender, MultipartFile file) throws IOException {
        String filename = UUID.randomUUID() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
        Path filePath = Paths.get(uploadDir, filename);
        Files.copy(file.getInputStream(), filePath);

        Message message = new Message();
        message.setSender(sender);
        message.setContent(filename);
        message.setType(MessageType.IMAGE);
        return messageRepository.save(message);
    }
}