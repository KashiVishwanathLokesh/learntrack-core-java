# Design Notes — LearnTrack (Core Java)

This document explains key design choices made in the LearnTrack project and how those choices support the project requirements.

---

## 1) Why I used `ArrayList` instead of array

I chose `ArrayList` for storing `Student`, `Course`, and `Enrollment` objects in service classes because this project is a menu-driven application where data size is dynamic.

### 1.1 Dynamic size requirement
In this application, users can:
- keep adding students/courses/enrollments,
- view records at any time,
- update status/active flags over time.

With a normal array, I would need to decide capacity in advance (for example `new Student[100]`).
If capacity is exceeded, I would have to create a new larger array and manually copy elements.
`ArrayList` handles this growth internally, so the code remains simple and focused on business logic.

### 1.2 Cleaner CRUD operations
`ArrayList` provides methods that are useful for this project:
- `add()` for insertion,
- `get(index)` and enhanced for-loop for reading,
- `remove()` if needed,
- `size()` and `isEmpty()` for checks.

This avoids manual index tracking, null-slot handling, and custom resizing logic that arrays would require.

### 1.3 Better readability and maintainability
Because this is a fundamentals project, readability is important.
Using `ArrayList<Student>`, `ArrayList<Course>`, and `ArrayList<Enrollment>` makes intention explicit and keeps service methods short and understandable.

### 1.4 Generic type safety
With generics (`ArrayList<Student>`), Java enforces type safety at compile time.
This prevents accidental insertion of wrong object types and reduces runtime errors.

### 1.5 Trade-off acknowledgement
`ArrayList` has small internal overhead compared to arrays and occasional resizing cost.
However, for this in-memory training project, the flexibility and clean code benefits are much more valuable than micro-optimizations.

---

## 2) Where I used static members and why

I used static members in the utility class `IdGenerator`.

### 2.1 Static fields used
- `private static int studentIdCounter`
- `private static int courseIdCounter`
- `private static int enrollmentIdCounter`

These fields store global counters used to create unique IDs.

### 2.2 Static methods used
- `public static int getNextStudentId()`
- `public static int getNextCourseId()`
- `public static int getNextEnrollmentId()`

These methods increment and return the next available ID.

### 2.3 Why static is appropriate here
ID generation is not behavior of one specific `Student` or `Course` object.
It is an application-level utility concern.
Using static members gives:
- a single shared counter source across the app,
- no need to create an `IdGenerator` object,
- consistent and predictable ID generation in all services.

### 2.4 Alignment with OOP fundamentals
This design demonstrates the difference between:
- **instance members** (belong to each object, e.g., `Student.batch`), and
- **static members** (belong to class-level shared state, e.g., ID counters).

This directly supports the learning objective “Static vs instance members”.

### 2.5 Future improvement note
If persistence (DB/file) is introduced later, ID generation may move to the database layer.
For now, static counters are a clean and valid approach for an in-memory console project.

---

## 3) Where I used inheritance and what I gained

I introduced a simple inheritance hierarchy:

- Base class: `Person`
- Derived class: `Student extends Person`
- (Optional extension possible later: `Trainer extends Person`)

### 3.1 Common fields moved to base class
`Person` contains:
- `id`
- `firstName`
- `lastName`
- `email`

`Student` adds only student-specific fields:
- `batch`
- `active`

### 3.2 Why this inheritance is useful
Without inheritance, these common fields would be duplicated in every person-like class (`Student`, `Trainer`, etc.).
Inheritance reduces duplication and centralizes shared structure.

### 3.3 Constructor chaining using `super`
In `Student` constructors, I used `super(...)` to initialize inherited fields from `Person`.
This demonstrates proper parent-child object construction flow and fulfills the requirement to use `super` in constructors.

### 3.4 Method overriding (basic polymorphism)
`Person` provides a generic `getDisplayName()` method.
`Student` overrides it with student-specific display behavior.

Benefit:
- same method name,
- different behavior depending on object type,
- practical introduction to runtime polymorphism in a simple form.

### 3.5 Practical gains in this project
1. **Code reuse**: shared identity fields and behavior are written once.
2. **Cleaner class responsibilities**: `Student` focuses only on student-specific state.
3. **Easy extensibility**: new classes like `Trainer` can be added with minimal effort.
4. **Better domain modeling**: reflects real-world hierarchy (a student is a person).

### 3.6 Learning outcome alignment
This design directly supports the project’s OOP goals:
- encapsulation,
- inheritance,
- constructor usage with `super`,
- basic polymorphism via overriding.

---

## Conclusion

The combination of:
- `ArrayList` for dynamic in-memory collections,
- static `IdGenerator` for shared utility behavior,
- inheritance (`Person` → `Student`) for reuse and structure,

helps keep LearnTrack modular, readable, and aligned with Core Java fundamentals.
These choices make the code easy to understand now and easy to extend in later cohorts (e.g., persistence layer, advanced validations, or additional user roles).