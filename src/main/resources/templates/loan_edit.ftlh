<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Edit Loan</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
  </head>
  <body>
  <H3>Edit Loan</H3>
    <br>
    <form method="post">
      <label for="name">ID:</label><br>
      <input type="text" id="uuid" name="uuid" required disabled value="${loan.uuid}"><br>
      <label for="name">Name:</label><br>
            <input type="text" id="name" name="name" required minlength="5" maxlength="50" value="${loan.name}"><br>
            <label for="limit">Limit:</label><br>
            <input type="text" id="limit" name="limit" required maxlength="20" value="${loan.limit?c}"><br>
            <label for="interest">Interest:</label><br>
            <input type="text" id="interest" name="interest" required maxlength="2" value="${loan.interestRate?c}"><br>
            <input type="submit" value="Update">
    </form>
  </body>
</html>
