package io.actbase.testdb.movieInfo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MovieInfoRepository extends JpaRepository<MovieInfo, Long>, JpaSpecificationExecutor<MovieInfo> {

}