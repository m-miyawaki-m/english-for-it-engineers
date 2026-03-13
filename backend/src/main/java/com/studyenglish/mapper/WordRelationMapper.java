package com.studyenglish.mapper;

import com.studyenglish.model.WordRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WordRelationMapper {

    List<WordRelation> findByWordId(@Param("wordId") int wordId);

    List<WordRelation> findByWordIds(@Param("wordIds") List<Integer> wordIds);
}
