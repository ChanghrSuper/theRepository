<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>


<center>
    <div style="padding-top: 70px;">

        <form id="updateEmpInfo" method="post">
            <input type="hidden" name="id" value="${param.id}" />
            <div style="margin-bottom: 15px;">
                <label for="name">Name:</label>
                <input class="easyui-textbox" type="text" name="name" data-options="required:true" />
            </div>
            <div style="margin-bottom: 15px;">
                <label for="password">Salary:</label>
                <input class="easyui-textbox" type="text" name="salary" data-options="required:true" />
            </div>
            <div style="margin-bottom: 15px;">
                <label for="name">Age:</label>
                <input class="easyui-textbox" type="text" name="age" data-options="required:true" />
            </div>
            <div style="margin-bottom: 15px;">
                <label for="name">Bir:</label>
                <input class="easyui-textbox" type="text" name="bir" data-options="required:true" />
            </div>
        </form>
    </div>

</center>

<script type="text/javascript">
    $(function(){
        //console.log(${param.id})
        $("#updateEmpInfo").form('load',"${pageContext.request.contextPath}/emp/queryOne?id=${param.id}");
    });
</script>