package com.chr.util;

import com.chr.entity.Product;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LuceneDaoImpl implements LuceneDao {
    @Override
    public List<Product> findProductByName(String keywords) {
        List<Product> products = new ArrayList<>();
        try {
            IndexSearcher indexSearcher = LuceneUtils.getIndexSearcher();
            TopDocs topDocs = indexSearcher.search(new TermQuery(new Term("name", keywords)), 100);
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            for (ScoreDoc scoreDoc : scoreDocs) {
                int doc = scoreDoc.doc;
                Document document = indexSearcher.doc(doc);
                Product product = new Product();
                product.setId(document.get("id"));
                product.setName(document.get("name"));
                product.setPath(document.get("path"));
                product.setPrice(Double.parseDouble(document.get("price")));
                product.setDiscount(Double.parseDouble(document.get("discount")));
                product.setDescription(document.get("description"));
                product.setSalecount(Integer.parseInt(document.get("salecount")));
                product.setStock(Integer.parseInt(document.get("stock")));
                product.setStatus(document.get("id"));
                products.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
