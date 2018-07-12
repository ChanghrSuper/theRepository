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
    <form id="saveTagForm" method="post" enctype="multipart/form-data">
        <div>
            <label for="name">Name:</label>
            <input class="easyui-textbox" type="text" name="name" data-options="required:true" />
        </div>
        <div>
            <label for="Level">Level:</label>
            <input class="easyui-textbox" type="text" name="lever" data-options="readonly:true,value:'4',required:true" />
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
            <input id="thirdtag" class="easyui-combobox" name="parentid" data-options="valueField:'id',textField:'name'" />
        </div>
        <div>
            <label for="Picture">上传图片:</label>
            <input class="easyui-filebox" name="file" style="width:300px" data-options="multiple:true,required:true,buttonText:'选择文件'">
        </div>
    </form>
</div>