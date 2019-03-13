package com.jqmkj.roadtrip.model.bo;

import com.jqmkj.roadtrip.model.vo.GankVo;

import java.util.List;

/**
 * JSON REST 返回对象
 */
public class GankResults extends BaseModel {

    private List<GankVo> results;

    public List<GankVo> getResults() {
        return results;
        }

        public void setResults(List<GankVo> results) {
            this.results = results;
            }

            @Override
            public boolean isNull() {
            return results == null || results.isEmpty();
            }

}