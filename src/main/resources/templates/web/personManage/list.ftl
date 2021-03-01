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
            dataType: "json",                   // 数据类型
            toolbar: $('#toolbar'),             //工具栏
            cache: false,                       //是否缓存
            striped: true,                      // 是否显示行间隔色
            showToggle: true,                   // 是否显示详细视图和列表视图的切换按钮
            uniqueId: "ID",                     // 每一行的唯一标识，一般为主键列

            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            pagination: true,                   //分页
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            showPaginationSwitch: false,        // 是否显示分页按钮
            paginationLoop: false,
            pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: false,                      //是否显示表格搜索
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列（选择显示的列）
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            undefinedText: '',                  // cell没有值时显示
            queryParams: queryParams,
            columns: [{
                field: 'id',
                width: '10%',
                title: 'ID'
            }, {
                field: 'uId',
                width: '20%',
                title: 'uId',
            }, {
                field: 'uaaId',
                width: '20%',
                title: 'uaaId'
            }, {
                field: 'psWord',
                width: '20%',
                title: 'psWord'
            }, {
                field: 'userName',
                width: '20%',
                title: 'userName'
            }
            ]
        });
    }

    // 查询条件与分页查询
    function queryParams(params) {
        params.pageNumber = this.pageNumber;
        params.pageSize = this.pageSize;

        return params;
    }
</script>
</body>