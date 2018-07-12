<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){
        $("#firsttag").combobox({
            url:'${pageContext.request.contextPath}/tag/queryByLevel?level=1',
            valueField:'id',
            textField:'name',
            onSelect: function(rec){
                var url = '${pageContext.request.contextPath}/tag/queryByPrtId?parentid='+rec.id;
                $("#secondtag").combobox('reload', url);
            }
        });
        $.post("${pageContext.request.contextPath}/product/queryOne",{id:'${param.id}'},
            function(data){
                console.log(data);
                $('#upProductForm').form('load',{
                    id:data.id,
                    name:data.name,
                    price:data.price,
                    discount:data.discount,
                    salecount:data.salecount,
                    stock:data.stock,
                    status:data.status,
                    description:data.description,
                    path:data.path
                });
            });
    });
</script>


<div>
    <form id="upProductForm" method="post" enctype="multipart/form-data">
        <div>
            <label for="ID">ID:</label>
            <input class="easyui-textbox" type="text" name="id" data-options="required:true,readonly:true" />
        </div>
        <div>
            <label for="name">商品名称:</label>
            <input class="easyui-textbox" type="text" name="name" data-options="required:true" />
        </div>
        <div>
            <label for="price">价格:</label>
            <input class="easyui-textbox" type="text" name="price" data-options="required:true" />
        </div>
        <div>
            <label for="discount">折扣:</label>
            <input class="easyui-textbox" type="text" name="discount" data-options="required:true" />
        </div>
        <div>
            <label for="salecount">销量:</label>
            <input class="easyui-textbox" type="text" name="salecount" data-options="required:true" />
        </div>
        <div>
            <label for="stock">库存:</label>
            <input class="easyui-textbox" type="text" name="stock" data-options="required:true" />
        </div>
        <div>
            <label for="status">状态:</label>
            <select id="cc" class="easyui-combobox" name="status" style="width:200px;">
                <option value="上架">上架</option>
                <option value="下架">下架</option>
                <option value="清仓">清仓</option>
                <option value="预售">预售</option>
                <option value="火爆">火热销售中</option>
            </select>

        </div>
        <div>
            <label for="description">描述:</label>
            <input class="easyui-textbox" type="text" name="description" data-options="required:true" />
        </div>
        <div>
            <label for="Path">Path:</label>
            <input class="easyui-textbox" type="text" name="path" data-options="required:true,readonly:true" />
        </div>
        <div>
            <label for="Picture">上传封面:</label>
            <input class="easyui-filebox" name="file" style="width:300px" data-options="multiple:true,buttonText:'选择文件'">
        </div>
    </form>
</div>