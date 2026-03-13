package com.studyenglish.mapper;

import com.studyenglish.model.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface WordMapper {

    List<Word> findAll(@Param("level") Integer level,
                       @Param("source") String source,
                       @Param("known") Integer known,
                       @Param("keyword") String keyword,
                       @Param("offset") int offset,
                       @Param("limit") int limit);

    int countAll(@Param("level") Integer level,
                 @Param("source") String source,
                 @Param("known") Integer known,
                 @Param("keyword") String keyword);

    Word findById(@Param("id") int id);

    void updateKnown(@Param("id") int id,
                     @Param("known") int known,
                     @Param("lastReviewed") String lastReviewed);

    Map<String, Object> getStats();
}
