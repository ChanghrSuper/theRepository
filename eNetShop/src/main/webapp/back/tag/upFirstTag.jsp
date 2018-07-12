<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){
        $.post("${pageContext.request.contextPath}/tag/queryOne",{id:'${param.id}'},
            function(data){
                console.log(data.name)
                $('#upTagForm').form('load',{
                    id:data.id,
                    name:data.name,
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
            <input class="easyui-textbox" type="text" name="lever" data-options="readonly:true,value:'1',required:true" />
        </div>
    </form>
</div>
