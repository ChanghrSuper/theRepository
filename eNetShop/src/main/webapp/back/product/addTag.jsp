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
    <form id="addTagForm" method="post">
        <div>
            <label for="ID">ID:</label>
            <input class="easyui-textbox" type="text" name="proid" data-options="required:true,value:'${param.id}',readonly:true" />
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
    </form>
</div>