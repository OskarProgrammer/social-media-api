# Social media api

Tables: 
users with endpoints:\n
  /getUsers
  /getUserById/{id}
  /getUserByName/{name}

  /createUser -> requestBody(User)

  /deleteAll
  /deleteUserWithId/{id}

  /changeUser/{id} -> requestBody(User)

posts with endpoints:
  /getPosts
  /getPostById/{id}
  /getAllPostsByOwnerId/{ownerId}

  /createPost -> requestBody(Post)

  /deleteAll
  /deletePost/{id}

  /changePost/{id} -> requestBody(Post)
