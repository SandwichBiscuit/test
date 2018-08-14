package cn.ps.dao;

import org.springframework.data.solr.repository.SolrCrudRepository;

import cn.ps.entity.News;

public interface NewDao extends SolrCrudRepository<News,String>{

}
