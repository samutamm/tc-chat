<!DOCTYPE html>
<html>
<head>
  <title>Chat</title>
</head>
<body>


<#if message??>
   ${user}: published the log to  <a href=${message}>${message} </a>
</#if>


<p>
  ${user}
  <a href="/logout">[ logout ]</a>
</p>

<form action="/post" method="POST">
  <p>
    <input type="text" name="message" value="">
    <input type="submit" value="Post">
  </p>
</form>
<form action="/" method="GET">
  <p>
    <input type="submit" value="Refresh">
  </p>
</form>

<h3>Posts:</h3>
<#list posts as post>
<p><strong>${post.author}:</strong> ${post.message}</p>
</#list>

<form action="/gists" method="POST">
  <p>
    <input type="submit" value="Send logs to gists">
  </p>
</form>

</body>
</html>