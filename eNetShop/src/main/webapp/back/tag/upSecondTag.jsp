<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){
        $("#firsttag").combobox({
            url:'${pageContext.request.contextPath}/tag/queryByLevel?level=1',
            valueField:'id',
            textField:'name'
        });
        $.post("${pageContext.request.contextPath}/tag/queryOne",{id:'${param.id}'},
            function(data){
                console.log(data.name)
                $('#upTagForm').form('load',{
                    id:data.id,
                    name:data.name,
                    //parentid:data.parentid,
                });
                //$("#firsttag").combobox('setValue', data.parentid);
                $.post("${pageContext.request.contextPath}/tag/queryOne",{id:data.parentid},
                    function(data){
                        console.log(data.name)
                        $("#firsttag").combobox('setValue', data.name);
                });
        });




    })
</script>

<div>
    <form id="upTagForm" method="post">
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
            <input class="easyui-textbox" type="text" name="lever" data-options="readonly:true,value:'2',required:true" />
        </div>
        <div>
            <label for="FirstTag">FirstTag:</label>
            <input id="firsttag" name="parentid">
        </div>
    </form>
</div>
