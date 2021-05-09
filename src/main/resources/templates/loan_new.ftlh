<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>New Loan</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
  </head>
  <body>
    <H3><a href="/">New loan</a></H3>
      <br>
    <form method="post">
      <label for="name">Name:</label><br>
      <input type="text" id="name" name="name" required minlength="5" maxlength="50"><br>
      <label for="limit">Limit:</label><br>
      <input type="text" id="limit" name="limit" required title="Enter 1 to 20 digits" pattern="[0-9]{1,20}"><br>
      <label for="interest">Interest:</label><br>
      <input type="text" id="interest" name="interest" pattern="[0-9]{1,2}"><br>
      <label for="bank">Bank:</label><br>
      <select name="bank" id="bank" required>
        <#if banks??>
          <#list banks as bank>
            <option value="${bank.uuid}">${bank.name}</option>
          </#list>
        </#if>
      </select><br>
      <input type="submit" value="Create">
    </form>
  </body>
</html>