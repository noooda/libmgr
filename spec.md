# Simple Library Management CLI
A command-line interface (CLI) application for managing a small-scale library.  
The focus is on managing books through registration, searching, and listing.

## Requirements

### 1. Book Registration
Allow users to register new books.
Each book should have:
- Title
- Author

### 2. Book Search
Allow users to search books by:
- Title
- Author

Support partial matches for title and author.
Search should return all matching books with full details.

### 3. List All Books
- Display a list of all registered books.
- Include key information (e.g. title, author).
- Optionally sort by title or author.

## Implementation Notes
- Use a list of book objects to manage the collection.
- Implement search logic using simple iteration over the list.
- Data persistence is not required (in-memory only).

## User Interface
CLI menu with the following options:
1. Register a new book
2. Search for books
3. List all books
4. Exit
