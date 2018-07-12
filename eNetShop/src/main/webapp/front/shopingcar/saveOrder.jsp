<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){

    });
</script>


<div>
    <form id="saveOrderForm" method="post">
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
            <label for="description">描述:</label>
            <input class="easyui-textbox" type="text" name="description" data-options="required:true" />
        </div>

    </form>
</div>