<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>New Client</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
  </head>
  <body>
    <H3>New client</H3>
      <br>
    <form method="post">
      <label for="name">Full name:</label><br>
      <input type="text" id="name" name="name" required minlength="5" maxlength="50"><br>
      <label for="phone">Phone number:</label><br>
      <input type="tel" id="phone" name="phone" required title="Enter 5 to 15 digits" pattern="[0-9]{5,15}"><br>
      <label for="email">Email:</label><br>
      <input type="email" id="email" name="email" required maxlength="50"><br>
      <label for="passport">Passport number:</label><br>
      <input type="text" id="passport" name="passport" required minlength="5" maxlength="20"><br>
      <input type="submit" value="Create">
    </form>
  </body>
</html>