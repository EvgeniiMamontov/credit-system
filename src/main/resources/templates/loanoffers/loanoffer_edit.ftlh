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
      <label for="loanoffer_uuid">UUID:</label><br>
      <input type="text" id="loanoffer_uuid" name="loanoffer_uuid" value="${loanoffer.uuid}" required disabled><br>
      <label for="client_uuid">Client:</label><br>
      <input type="text" id="client_uuid" name="client_uuid" value="${client.uuid}" required><br>
      <label for="loans">Loans:</label><br>
      <select name="loans_uuid" id="loans_uuid" required>
        <#if loans??>
          <#list loans as loan>
            <option
                <#if loanoffer.loan.uuid == loan.uuid> selected </#if>
             value="${loan.uuid}">${loan.name}</option>
          </#list>
        </#if>
      </select><br>
      <label for="summ">Loan amount:</label><br>
      <input type="text" id="summ" name="summ" pattern="[0-9]{1,20}" value="${loanoffer.amount?c}" required><br>
      <label for="loan_term">Loan term:</label><br>
      <input type="text" id="loan_term" name="loan_term" pattern="[0-9]{1,3}" min="1" max="240" value="${loanoffer.loanTerm?c}" required><br>
      <label for="date" required>First payment date:</label><br>
      <input type="date" id="date" name="date" value="${loanoffer.date}" required><br>

      <input type="submit" value="Update">
    </form>
  </body>
</html>