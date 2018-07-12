package com.chr.service.impl;

import com.chr.util.LuceneDao;
import com.chr.dao.ProductMapper;
import com.chr.dao.TagMapper;
import com.chr.dao.Tag_ProductMapper;
import com.chr.entity.*;
import com.chr.service.ProductService;
import com.chr.util.LuceneUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;
    @Resource
    private Tag_ProductMapper tpMapper;
    @Resource
    private TagMapper tagMapper;
    @Resource
    private LuceneDao luceneDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public PageInfo<Product> findAll(Integer page, Integer rows) {
        System.out.println("--------"+page+"  "+rows);
        PageHelper.startPage(page,rows);
        ProductExample example = new ProductExample();
        List<Product> products = productMapper.selectByExample(example);
        System.out.println(products.size());
        for (Product product : products) {
            Tag_ProductExample tpexample = new Tag_ProductExample();
            tpexample.createCriteria().andProidEqualTo(product.getId());
            List<Tag_Product> tps = tpMapper.selectByExample(tpexample);
            List<String> tids = new ArrayList<>();
            for (Tag_Product tp : tps) {
                tids.add(tp.getTagid());
            }
            TagExample tagexample = new TagExample();
            tagexample.createCriteria().andIdIn(tids);
            List<Tag> tags = tagMapper.selectByExample(tagexample);
            product.setTags(tags);
        }
        PageInfo<Product> pageInfo = new PageInfo<>(products);

        return pageInfo;
    }

    @Override
    public void add(Product product, String tagid) {
        String proid = UUID.randomUUID().toString();
        product.setId(proid);
        Tag_Product tp = new Tag_Product();
        tp.setProid(proid);
        tp.setTagid(tagid);
        tpMapper.insert(tp);
        productMapper.insert(product);

        //添加进Lucene索引
        IndexWriter indexWriter = LuceneUtils.getIndexWriter();
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
        LuceneUtils.commit();
    }

    @Override
    public void remove(String id) {
        Tag_ProductExample example = new Tag_ProductExample();
        example.createCriteria().andProidEqualTo(id);
        tpMapper.deleteByExample(example);
        productMapper.deleteByPrimaryKey(id);

        //从Lucene索引中移除
        IndexWriter indexWriter = LuceneUtils.getIndexWriter();
        try {
            indexWriter.deleteDocuments(new Term("id",id));
        } catch (IOException e) {
            e.printStackTrace();
        }
        LuceneUtils.commit();
    }

    @Override
    public void modify(Product product) {
        productMapper.updateByPrimaryKeySelective(product);

        //更新Lucene中索引
        IndexWriter indexWriter = LuceneUtils.getIndexWriter();
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
            indexWriter.updateDocument(new Term("id",product.getId()),document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LuceneUtils.commit();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Product findOne(String id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public void removeAll(List<String> ids) {
        ProductExample example = new ProductExample();
        example.createCriteria().andIdIn(ids);
        productMapper.deleteByExample(example);
        Tag_ProductExample texample = new Tag_ProductExample();
        for (String id : ids) {
            texample.createCriteria().andProidEqualTo(id);
            tpMapper.deleteByExample(texample);
        }
    }

    @Override
    public List<Tag> findTag(String id) {
        Tag_ProductExample tpexample = new Tag_ProductExample();
        tpexample.createCriteria().andProidEqualTo(id);
        List<Tag_Product> tps = tpMapper.selectByExample(tpexample);
        List<String> tids = new ArrayList<>();
        for (Tag_Product tp : tps) {
            tids.add(tp.getTagid());
        }
        TagExample tagexample = new TagExample();
        tagexample.createCriteria().andIdIn(tids);
        return tagMapper.selectByExample(tagexample);
    }

    @Override
    public void addTag(String proid, String tagid) {
        Tag_Product tp = new Tag_Product();
        tp.setProid(proid);
        tp.setTagid(tagid);
        tpMapper.insert(tp);
    }

    @Override
    public void delTag(String proid, String tagid) {
        Tag_ProductExample example = new Tag_ProductExample();
        example.createCriteria().andProidEqualTo(proid).andTagidEqualTo(tagid);
        tpMapper.deleteByExample(example);
    }

    @Override
    public List<Product> All() {
        ProductExample example = new ProductExample();
        List<Product> products = productMapper.selectByExample(example);
        for (Product product : products) {
            Tag_ProductExample tpexample = new Tag_ProductExample();
            tpexample.createCriteria().andProidEqualTo(product.getId());
            List<Tag_Product> tps = tpMapper.selectByExample(tpexample);
            List<String> tids = new ArrayList<>();
            for (Tag_Product tp : tps) {
                tids.add(tp.getTagid());
            }
            TagExample tagexample = new TagExample();
            tagexample.createCriteria().andIdIn(tids);
            List<Tag> tags = tagMapper.selectByExample(tagexample);
            product.setTags(tags);
        }
        return products;
    }

    @Override
    public List<Product> findProductByName(String keywords) {
        return luceneDao.findProductByName(keywords);
    }
}
