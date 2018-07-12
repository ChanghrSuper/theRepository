<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function () {




    })
</script>


<div>
    <form id="saveAddrForm" method="post">
        <div>
            <label for="Level">账号ID:</label>
            <input class="easyui-textbox" type="text" name="userid" data-options="value:'${param.id}',readonly:true,required:true" />
        </div>
        <div>
            <label for="Level">收货人:</label>
            <input class="easyui-textbox" type="text" name="getername" data-options="required:true" />
        </div>
        <div>
            <label for="Level">电话:</label>
            <input class="easyui-textbox" type="text" name="phonenumber" data-options="required:true" />
        </div>
        <div>
            <label for="Level">地区:</label>
            <input class="easyui-textbox" type="text" name="area" data-options="required:true" />
        </div>
        <div>
            <label for="Level">地址:</label>
            <input class="easyui-textbox" type="text" name="address" data-options="required:true" />
        </div>
        <div>
            <label for="Level">状态:</label>
            <select id="addrStatus" class="easyui-combobox" name="status" style="width:200px;">
                <option value="默认">默认</option>
                <option value="可用">可用</option>
                <option value="冻结">冻结</option>
            </select>
        </div>
    </form>
</div>