<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>第一个freemarker页面</title>
</head>
<body>
    <h2>配置ftl</h2>
    <div>${data.message}</div>
    <hr>

    <table border="2px">

        <#list data.data as item>
            <tr>
                <td>${item.id}</td>
                <td>${item.psWord}</td>
                <td>${item.UId}</td>
                <td>${item.userName}</td>
            </tr>
        </#list>

    </table>

</body>
</html>