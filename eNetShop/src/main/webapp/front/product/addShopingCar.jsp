<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){
        $('#count').textbox({
            value:1,
            icons: [{
                iconCls:'icon-add',
                handler: function(e){
                    var num = parseInt($(e.data.target).textbox('getValue'));
                    $(e.data.target).textbox('setValue', num+1);
                }
            },{
                iconCls:'icon-remove',
                handler: function(e){
                    var num = parseInt($(e.data.target).textbox('getValue'));
                    if(num>1){
                        $(e.data.target).textbox('setValue', num-1);
                    }
                }
            }]

        })


    });
</script>


<div>
    <form id="saveShoppingCar" method="post">
        <div>
            <label for="id">商品ID:</label>
            <input class="easyui-textbox" type="text" name="proid" data-options="readonly:true,value:'${param.proid}',required:true" />
        </div>
        <div>
            <label for="num">数量:</label>
            <input id="count" name="number" style="width:100px">
        </div>
    </form>
</div>