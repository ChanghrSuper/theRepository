<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){

        $.post("${pageContext.request.contextPath}/product/queryTag", {id:'${param.id}'},
            function(data){
                $.each(data,function(index, row){
                    console.log(row.name);
                    $("#div").append("<a id='"+ row.id +"' class='easyui-linkbutton delbtn' href='javascript:;' onClick=\"deltag('"+ row.id +"');\" >"+row.name+"</a> ");
                    $('.delbtn').linkbutton({
                        iconCls: 'icon-bullet_cross',
                    });
                });
            });
    });

    function deltag(tagid) {
        console.log(tagid);
        $.post("${pageContext.request.contextPath}/product/delTag", {proid:'${param.id}',tagid:tagid},
            function(data){
                $("#da").dialog('close');
                $("#dg").datagrid('reload');
    });
    }
</script>


<div id="div" align="center" style="margin-top: 100px"></div>