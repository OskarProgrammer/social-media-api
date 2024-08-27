# Social media api

Tables: 
users with endpoints:
  /getUsers
  /getUserById/{id}
  /getUsersByName/{name}

  /createUser -> requestBody(User) and also change the existing

  /deleteAll
  /deleteUserWithId/{id}


posts with endpoints:
  /getPosts
  /getPostById/{id}
  /getPostsByOwnerId/{ownerId}

  /createPost -> requestBody(Post) and also change the existing 

  /deleteAll
  /deletePost/{id}

comments with endpoints:
  /getComments
  /getCommentsById/{id} 
  /getCommentsByPostId/{postId}
  /getCommentsByOwnerId/{ownerId}

  /createComment -> requestBody(Comment) and also change the existing

  /deleteAll
  /deleteAllByOwnerId/{id}
  
