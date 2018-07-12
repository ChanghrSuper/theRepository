<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false" %>


    <div   style="margin-top:100px;margin-left: 150px">
        <form id="ff" method="post">
            <div>
                Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="easyui-textbox" type="text" name="name" data-options="" />
            </div>
            <br/>
            <div>
                Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="easyui-textbox" type="text" name="price" data-options="" />
            </div>
            <br/>
            <div>
                Description:
                <input class="easyui-textbox" type="text" name="description" data-options="" />
            </div>
            <br/>
            <div>
                ProAddr:&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="easyui-textbox" type="text" name="proaddr" data-options="" />
            </div>
            <br/>
            <a id="btn" href="javascript:;" class="easyui-linkbutton" data-options="onClick:add,iconCls:'icon-save'">保存</a>
        </form>
    </div>


