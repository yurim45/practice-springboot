package io.actbase.testdb.movieInfo.service;

import io.actbase.testdb.movieInfo.domain.MovieInfo;
import io.actbase.testdb.movieInfo.domain.MovieInfoRepository;
import io.actbase.testdb.movieInfo.dto.MovieInfoDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieInfoService {

    private final MovieInfoRepository movieInfoRepository;
    private final ModelMapper modelMapper;


    @Transactional
    public MovieInfoDto.Response createMovieInfo(MovieInfoDto.Create dto) {
        MovieInfo newReport = modelMapper.map(dto, MovieInfo.class);
        return toResponse(movieInfoRepository.save(newReport));
    }

    public Page<MovieInfoDto.Response> getMovieInfo(Pageable pageable) {
        Page<MovieInfo> page = movieInfoRepository.findAll(pageable);
        List<MovieInfoDto.Response> content = page.getContent().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return new PageImpl<>(content, pageable, page.getTotalElements());
    }

    @Transactional
    public void deleteMovieInfo(
            final Long id
    ) {
        MovieInfo existReport = this.validate(id);
        movieInfoRepository.delete(existReport);
    }

    private MovieInfoDto.Response toResponse(MovieInfo movieInfo) {
        return modelMapper.map(movieInfo, MovieInfoDto.Response.class);
    }

    private MovieInfo validate(
            final Long id
    ) {

        MovieInfo existMovieInfo = movieInfoRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return existMovieInfo;
    }
}
