package com.example.project01.Service;

import com.example.project01.Entity.Heart;
import com.example.project01.Repository.HeartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class HeartService {

    private final HeartRepository heartRepository;



    public Heart addHeart(Heart heart) throws IOException {
        Heart h = Heart.builder()
                .postId(heart.getPostId())
                .userId(heart.getUserId())
                .build();
        return heartRepository.save(h);
    }

    public void removeHeart(Heart heart) throws IOException {


        Optional<Heart> heartOpt = heartRepository.findByUserIdAndPostId(heart.getUserId(), heart.getPostId());


        heartRepository.delete(heartOpt.get());


    }


}