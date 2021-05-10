<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>New Loan Offer</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
  </head>
  <body>
    <H3><a href="/">New loan offer</a></H3>
      <br>
    <form method="post">
      <label for="client_uuid">Client:</label><br>
      <input type="text" id="client_uuid" name="client_uuid" value="${client.uuid}" required><br>
      <label for="loans">Loans:</label><br>
      <select name="loans_uuid" id="loans_uuid" required>
        <#if loans??>
          <#list loans as loan>
            <option value="${loan.uuid}">${loan.name}</option>
          </#list>
        </#if>
      </select><br>
      <label for="summ">Loan amount:</label><br>
      <input type="text" id="summ" name="summ" pattern="[0-9]{1,20}" required><br>
      <label for="loan_term">Loan term:</label><br>
      <input type="text" id="loan_term" name="loan_term" pattern="[0-9]{1,3}" min="1" max="240" required><br>
      <label for="date" required>First payment date:</label><br>
      <input type="date" id="date" name="date" required><br>

      <input type="submit" value="Create">
    </form>
  </body>
</html>