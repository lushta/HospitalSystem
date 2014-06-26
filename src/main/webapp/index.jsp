<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html SYSTEM "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
        <title>Hospital</title>
        <link rel="stylesheet" type="text/css" href="css/formatting.css" />
    </head>
    <body>
    <div id="wrapper" >
            <h1 >
                Вітаємо Вас в системі Hospital! <br/>
                Авторизуйтесь, будь ласка:
            </h1>
            <div >
            <form action="/Hospital/authorization" method="post">
                <table style="margin: auto">
                    <tr>
                        <td style="text-align: left">Логін:</td>
                        <td><input name="login" type="text" size="20" required /></td>
                    </tr>
                    <tr>
                        <td style="text-align: left">Пароль:</td>
                        <td><input name="password" type="password" size="20"
                                   maxlength="20" required /></td>
                    </tr>
                    <tr>
                        <td style="text-align: left">Мова:</td>
                        <td>
                            <input type="radio" name="language" value="ua" required checked/>Українська<Br>
                            <input type="radio" name="language" value="en" required/>English<Br>
                        </td>
                    </tr>
                </table>
                <table style="margin: auto">
                    <tr>
                        <td><input type="submit" class="button-accept" value="Вхід" /></td>
                    </tr>
                </table>
            </form>
            </div>
        </div>
    </body>
</html>
