<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Edit Bank</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
  </head>
  <body>
  <H3>Edit Bank</H3>
    <br>
    <form method="post">
      <label for="name">ID:</label><br>
      <input type="text" id="uuid" name="uuid" required disabled value="${bank.uuid}"><br>
      <label for="name">Name:</label><br>
      <input type="text" id="name" name="name" required minlength="5" maxlength="50" value="${bank.name}"><br>
      <label for="limit">Limit:</label><br>
      <input type="submit" value="Update">
    </form>
  </body>
</html>
