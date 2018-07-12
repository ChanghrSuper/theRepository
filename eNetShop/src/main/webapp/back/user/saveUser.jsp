<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>

<script type="text/javascript">

    $(function () {
        $('#dd').datebox({
            required:true
        });


    })
</script>


<div>
    <form id="saveUserForm" method="post" enctype="multipart/form-data">
        <div>
            <label for="name">电话:</label>
            <input class="easyui-textbox" type="text" name="phonenumber" data-options="required:true" />
        </div>
        <div>
            <label for="Level">头像:</label>
            <input class="easyui-filebox" type="text" name="file" data-options="required:true" style="width:300px" />
        </div>
        <div>
            <label for="Level">昵称:</label>
            <input class="easyui-textbox" type="text" name="nickname" data-options="required:true" />
        </div>
        <div>
            <label for="Level">真实姓名:</label>
            <input class="easyui-textbox" type="text" name="realname" data-options="required:true" />
        </div>
        <div>
            <label for="Level">性别:</label>
            <select id="cc" class="easyui-combobox" name="sex" style="width:200px;">
                <option value="男">男</option>
                <option value="女">女</option>
                <option value="不公开">不公开</option>
            </select>
        </div>
        <div>
            <label for="Level">生日:</label>
            <input id="dd" name="birthday" type="text"/>
        </div>
        <div>
            <label for="Level">地址:</label>
            <input class="easyui-textbox" type="text" name="address" data-options="required:true" />
        </div>
        <div>
            <label for="Level">身份证:</label>
            <input class="easyui-textbox" type="text" name="idcard" data-options="required:true" />
        </div>
    </form>
</div>