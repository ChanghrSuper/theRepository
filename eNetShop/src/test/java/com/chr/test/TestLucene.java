package com.chr.test;

import com.chr.Application;
import com.chr.entity.Product;
import com.chr.service.ProductService;
import com.chr.util.LuceneUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestLucene {

    @Resource
    private ProductService productService;

    @Test
    public void testCreateIndex() throws IOException {
        //创建一个索引目录
        FSDirectory dir = FSDirectory.open(new File("./index"));
        //创建索引的配置对象
        //参数1：lucene版本 参数2：分词器对象
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_44);
        IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_44, analyzer);
        //创建索引的写出对象
        //参数1：索引写出位置  参数2：写出的配置对象
        IndexWriter indexWriter = new IndexWriter(dir, conf);
        //对一个文章创建索引
        //创建一个dicument文档
        Document document = new Document();
        document.add(new StringField("id","1",Field.Store.YES));
        document.add(new StringField("title","我是一个粉刷匠",Field.Store.YES));
        document.add(new StringField("create",new SimpleDateFormat("yyyy-MM-dd").format(new Date()),Field.Store.YES));
        document.add(new StringField("author","粉刷匠",Field.Store.YES));
        document.add(new TextField("content","粉刷本领强，我要把那新房子，刷的更漂亮！！！",Field.Store.YES));
        indexWriter.addDocument(document);
        //关闭资源
        indexWriter.commit();//indexWriter.rollback();
        indexWriter.close();
    }


    @Test
    public void testIndexSearch() throws IOException {

        FSDirectory dir = FSDirectory.open(new File("./index"));
        //读取索引库的位置
        DirectoryReader directoryReader = DirectoryReader.open(dir);
        //创建索引的搜索的对象
        IndexSearcher indexSearcher = new IndexSearcher(directoryReader);

        //搜索
        //参数1：搜索条件  参数2：要搜索结果的前多少条
        TopDocs topDocs = indexSearcher.search(new TermQuery(new Term("id", "1")), 100);

        ScoreDoc[] scoreDocs = topDocs.scoreDocs;//相关度排序

        for (int i = 0; i <scoreDocs.length ; i++) {
            //文章在索引索引库中唯一标识
            int doc = scoreDocs[i].doc;
            System.out.println("当前文章的得分： "+scoreDocs[i].score);
            Document document = indexSearcher.doc(doc);
            System.out.println(document.get("id"));
            System.out.println(document.get("title"));
            System.out.println(document.get("create"));
            System.out.println(document.get("author"));
            System.out.println(document.get("content"));
            System.out.println("======================================");
        }

    }

    @Test
    public void testDeleteIndex() throws IOException {

        FSDirectory dir = FSDirectory.open(new File("./index"));
        IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_44, new StandardAnalyzer(Version.LUCENE_44));

        IndexWriter indexWriter = new IndexWriter(dir, conf);

        indexWriter.deleteDocuments(new Term("id","1"));

        indexWriter.commit();
        indexWriter.close();
    }

    @Test
    public void prepareProducts(){

        List<Product> products = productService.All();

        IndexWriter indexWriter = LuceneUtils.getIndexWriter();

        for (Product product : products) {
            Document document = new Document();
            document.add(new StringField("id",product.getId(),Field.Store.YES));
            document.add(new StringField("name",product.getName(),Field.Store.YES));
            document.add(new StringField("path",product.getPath(),Field.Store.YES));
            document.add(new DoubleField("price",product.getPrice(),Field.Store.YES));
            document.add(new DoubleField("discount",product.getDiscount(),Field.Store.YES));
            document.add(new StringField("description",product.getDescription(),Field.Store.NO));
            document.add(new IntField("salecount",product.getSalecount(),Field.Store.YES));
            document.add(new IntField("stock",product.getStock(),Field.Store.YES));
            document.add(new StringField("status",product.getStatus(),Field.Store.YES));
            try {
                indexWriter.addDocument(document);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        LuceneUtils.commit();
    }

    @Test
    public void testSearchProduct(){
        List<Product> list = productService.findProductByName("测试修改");
        for (Product product : list) {
            System.out.println(product.getName());
            System.out.println(product.getSalecount());
            System.out.println(product.getDescription());
        }
    }

}
