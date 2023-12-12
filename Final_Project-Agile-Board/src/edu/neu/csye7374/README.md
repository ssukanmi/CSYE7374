----------- CSYE 7374 FINAL PROJECT ------------
Operating Instructions:
• This is a Command Line Application hence all inputs and outputs are from and to the console. No graphical user interface is implemented.
• User Interface is menu-driven, please refer to the options given to the user some options to move to the next step or to go back.

A. Account has:
• role: Enumeration of TeamLeader / TeamMember.
• id: Int
• username: String.
• password: String.
• displayName: String. 

B. Task has the following properties:
• description: String.
• status: Enumeration of TODO/DOING/DONE.
• id: Int.
• assignedMember: Whatever type you select.

C. Team leader is able to:
• Create Task.
• Update Task (update property: description & assignedMember).
• View Tasks.
• Delete Task.

D. Team member is able to:
• View Tasks that are assigned to him.
• Update Task (update property: status).

Edge Cases Covered:
• When a member has >= 2 DOING tasks, this member should not be assigned new tasks.
• When a task is in DOING status, it should not be deleted or assigned to a new member.
• When a task is in DONE status, it should not be assigned to a new member.
