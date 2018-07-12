<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>



<div>
    <form id="saveTagForm" method="post">
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