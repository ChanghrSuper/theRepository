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
    });
</script>


<div>
    <form id="saveProductForm" method="post" enctype="multipart/form-data">
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
            <label for="FirstTag">FirstTag:</label>
            <input id="firsttag" name="">
        </div>
        <div>
            <label for="SecondTag">SecondTag:</label>
            <input id="secondtag" class="easyui-combobox" name="" data-options="valueField:'id',textField:'name',
                onSelect: function(rec){
                var url = '${pageContext.request.contextPath}/tag/queryByPrtId?parentid='+rec.id;
                $('#thirdtag').combobox('reload', url);
            }" >
        </div>
        <div>
            <label for="ThirdTag">ThirdTag:</label>
            <input id="thirdtag" class="easyui-combobox" name="" data-options="valueField:'id',textField:'name',
                onSelect: function(rec){
                var url = '${pageContext.request.contextPath}/tag/queryByPrtId?parentid='+rec.id;
                $('#fourthtag').combobox('reload', url);
            }" >
        </div>
        <div>
            <label for="FourthTag">FourthTag:</label>
            <input id="fourthtag" class="easyui-combobox" name="tagid" data-options="valueField:'id',textField:'name'" />
        </div>
        <div>
            <label for="Picture">上传封面:</label>
            <input class="easyui-filebox" name="file" style="width:300px" data-options="multiple:true,required:true,buttonText:'选择文件'">
        </div>
    </form>
</div>