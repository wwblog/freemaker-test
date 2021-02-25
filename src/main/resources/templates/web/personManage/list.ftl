<head title="人员管理">
    <#include "../layout/layout.ftl">
    <title>人员管理</title>
    <style>
        .table th, .table td {
            text-align: center;
            vertical-align: middle !important;
        }

        .col-md-2 {
            width: 250px
        }
    </style>
</head>

<body>
<div class="">
    <div class="row-fluid">
        <div class="control-group form-inline" style="border: 1px solid #ccc;padding: 10px; border-radius: 3px;">
            <div class="input-group input-group-sm col-md-2">
                <label for="id">雇员ID:</label>
                <input type="text" class="default-input"
                       id="id" name="id" placeholder="雇员ID">
            </div>
            <div class="input-group input-group-sm col-md-2">
                <label for="empName">雇员名称:</label>
                <input type="text" class="default-input"
                       id="empName" name="empName" placeholder="雇员名称">
            </div>
            <button id="btn_search" class="btn btn-info">查询</button>
            <button id="btn_reset" class="btn btn-info">重置</button>
        </div>
    </div>
    <div class="row">
        <div class="tab-content" id="tabContent">
            <div id="toolbar" class="btn-group">
                <button id="btn_add" type="button" class="btn btn-info btn-sm rightSize">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
                </button>

            </div>
            <div id="loginLogTab" class="tab-pane active">
                <div class="table-responsive">
                    <table id="tb"></table>
                </div>
            </div>
        </div>
    </div>

</div>

<script type="text/javascript">
    var $table = $('#tb');
    // bootstrapTable使用中文
    $.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales['zh-CN']);
    // 防止表头与表格不对齐
    $(window).resize(function () {
        $table.bootstrapTable('resetView');
    });
    $(function () {
        // 使用严格模式
        "use strict";
        tableInit();
    });

    function tableInit() {
        $table.bootstrapTable('destroy');
        $table.bootstrapTable({
            url: '/personManage/empList',
            // 请求方式
            method: 'post',
            // 请求内容类型
            contentType: "application/x-www-form-urlencoded",
            // 数据类型
            dataType: "json",
            //分页
            pagination: true,
            //工具栏
            toolbar: $('#toolbar'),
            // 是否显示行间隔色
            striped: true,
            // 显示刷新按钮
            showRefresh: true,
            // 切换显示样式
            showToggle: true,
            // 是否显示分页按钮
            showPaginationSwitch: false,
            paginationLoop: false,

            columns: [{
                field: 'id',
                title: 'ID'
            }, {
                field: 'uId',
                title: 'uId'
            }, {
                field: 'uaaId',
                title: 'uaaId'
            }, {
                field: 'psWord',
                title: 'psWord'
            }, {
                field: 'userName',
                title: 'userName'
            }
            ]
        });
    }
</script>
</body>