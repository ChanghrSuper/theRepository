<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){

        $.post("${pageContext.request.contextPath}/user/queryAddr", {userid:'${param.id}'},
            function(data){
                $.each(data,function(index, row){
                    console.log(row);
                    $("#div").append("<a id='"+ row.id +"' class='easyui-linkbutton delbtn' href='javascript:;' onClick=\"deladdr('"+ row.id +"');\" >"+row.area+"  "+row.address+"  "+row.getername+"  "+row.phonenumber+"  "+row.status+"</a><br/> ");
                    $('.delbtn').linkbutton({
                        iconCls: 'icon-bullet_cross',
                    });
                });
                $("#div").append("<br/><a id='addAddr' class='easyui-linkbutton delbtn' href='javascript:;' onClick=\"openAddAddr('"+ '${param.id}' +"')\" ></a><br/> ");
                $('#addAddr').linkbutton({
                    iconCls: 'icon-add',
                });
            });
    });

    function deladdr(id) {
        console.log(id);
        $.post("${pageContext.request.contextPath}/user/delAddr", {id:id},
            function(data){
                $("#da").dialog('close');
                $("#dg").datagrid('reload');
        });
    }


</script>


<div id="div" align="center" style="margin-top: 100px"></div>