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
        $.post("${pageContext.request.contextPath}/tag/queryOne",{id:'${param.id}'},
            function(data){
                console.log(data);
                $('#upTagForm').form('load',{
                    id:data.id,
                    name:data.name,
                });
                $.post("${pageContext.request.contextPath}/tag/queryOne",{id:data.parentid},
                    function(data){
                        console.log(data.name)
                        $("#thirdtag").combobox('setValue', data.name);
                        $.post("${pageContext.request.contextPath}/tag/queryOne",{id:data.parentid},
                            function(data){
                                console.log(data.name)
                                $("#secondtag").combobox('setValue', data.name);
                                $.post("${pageContext.request.contextPath}/tag/queryOne",{id:data.parentid},
                                    function(data){
                                        console.log(data.name)
                                        $("#firsttag").combobox('setValue', data.name);
                                });
                        });
                    });
            });
    });
</script>


<div>
    <form id="upTagForm" method="post" enctype="multipart/form-data">
        <div>
            <label for="ID">ID:</label>
            <input class="easyui-textbox" type="text" name="id" data-options="required:true" />
        </div>
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
    </form>
</div>