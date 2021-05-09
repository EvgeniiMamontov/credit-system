<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Edit Loan</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
  </head>
  <body>
  <H3><a href="/">Edit Loan</a></H3>
    <br>
    <form method="post">
      <label for="name">ID:</label><br>
      <input type="text" id="uuid" name="uuid" required disabled value="${loan.uuid}"><br>
      <label for="name">Name:</label><br>
            <input type="text" id="name" name="name" required minlength="5" maxlength="50" value="${loan.name}"><br>
            <label for="limit">Limit:</label><br>
            <input type="text" id="limit" name="limit" required title="Enter 1 to 20 digits" pattern="[0-9]{1,20}" value="${loan.limit?c}"><br>
            <label for="interest">Interest:</label><br>
            <input type="text" id="interest" name="interest" required pattern="[0-9]{1,2}" value="${loan.interestRate?c}"><br>
            <label for="bank">Bank:</label><br>
              <select name="bank" id="bank" required>
                <#if banks??>
                  <#list banks as bank>
                    <option value="${bank.uuid}">${bank.name}</option>
                  </#list>
                </#if>
              </select><br>
            <input type="submit" value="Update">
    </form>
  </body>
</html>
