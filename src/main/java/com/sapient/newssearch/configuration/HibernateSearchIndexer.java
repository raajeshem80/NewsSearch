//package com.sapient.newssearch.configuration;
//
//import org.hibernate.search.mapper.orm.Search;
//import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
//import org.hibernate.search.mapper.orm.session.SearchSession;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.sapient.newssearch.exceptions.NewsApiException;
//
//import javax.persistence.EntityManager;
//
// /**
// * Rajesh Engimoori
// * Created on Jan 10, 2023
// * Email: rajesh.em@gmail.com
// **/
//
//@Transactional
//@Component
//public class HibernateSearchIndexer {
//
//    private EntityManager entityManager;
//
//    private static final int THREAD_NUMBER = 4;
//
//    public HibernateSearchIndexer(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    public void indexPersistedData(String indexClassName) throws NewsApiException {
//
//        try {
//            SearchSession searchSession = Search.session(entityManager);
//
//            Class<?> classToIndex = Class.forName(indexClassName);
//            MassIndexer indexer =
//                    searchSession
//                            .massIndexer(classToIndex)
//                            .threadsToLoadObjects(THREAD_NUMBER);
//
//            indexer.startAndWait();
//        } catch (ClassNotFoundException e) {
//            throw new NewsApiException("Invalid class " + indexClassName, e);
//        } catch (InterruptedException e) {
//            throw new NewsApiException("Index Interrupted", e);
//        }
//    }
//}
