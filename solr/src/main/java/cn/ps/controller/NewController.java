package cn.ps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.HighlightOptions;
import org.springframework.data.solr.core.query.SimpleHighlightQuery;
import org.springframework.data.solr.core.query.SimpleStringCriteria;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ps.dao.NewDao;
import cn.ps.entity.News;

@RestController
public class NewController {

	@Autowired
	private SolrTemplate solrTemplate;
	
	@Autowired
	private NewDao newDao;
	
	@RequestMapping("/query")
	public Iterable<News> query(){
		Iterable<News> findall=newDao.findAll();
		return findall;
	}
	
	@RequestMapping("/queryHign")
	public List<News> queryHign(){
		SimpleHighlightQuery query=new SimpleHighlightQuery(new SimpleStringCriteria("username_ik:用户名"));
		HighlightOptions highlightOptions=new HighlightOptions();
		highlightOptions.setSimplePrefix("<font color=red>");
		highlightOptions.setSimplePostfix("</font>");
		query.setHighlightOptions(highlightOptions);
		
		HighlightPage<News> page=solrTemplate.queryForHighlightPage(query, News.class);
		//用户名列表要求将高亮中的username_it覆盖对象中的username_it
		List<News> cont=page.getContent();
		for (News news : cont) {
			//循环每一条数据
			String newid=news.getId();
			List<HighlightEntry<News>> highlightEntries=page.getHighlighted();
			for (HighlightEntry<News> highlightEntry : highlightEntries) {
				if (highlightEntry.getEntity().getId().equals(newid)) {
					String snipet=highlightEntry.getHighlights().get(0).getSnipplets().get(0);
					news.setUsername_ik(snipet);
				}
			}
		}
		return cont;
	}
}
