Smart Office App 🏢💡❄️

A console-based Smart Office simulation that demonstrates Command Pattern, Observer Pattern, and Singleton Pattern in Java.

The system allows configuring meeting rooms, booking/canceling, adding occupants, and automatically controlling lights & AC.

 Project Structure
smart-office/
  src/
    com/smartoffice/
      Main.java
      OfficeConfig.java
      Room.java
      Booking.java
      Observer.java
      ControllerLight.java
      ControllerAC.java
      Command.java
      CommandInvoker.java
      commands/
        ConfigureCommand.java
        SetCapacityCommand.java
        BookRoomCommand.java
        CancelBookingCommand.java
        AddOccupantCommand.java

▶️ How to Compile & Run

Open terminal inside smart-office/src

Compile:

javac com/smartoffice/*.java com/smartoffice/commands/*.java


Run:

java com.smartoffice.Main

💻 Commands
Command	Example	Description
config room count <n>	config room count 3	Creates n rooms
config room maxcapacity <roomId> <capacity>	config room maxcapacity 1 10	Set max capacity for room
book <roomId> <HH:MM> <minutes>	book 1 09:00 60	Book a room
cancel <roomId>	cancel 1	Cancel room booking
add occupant <roomId> <count>	add occupant 1 8	Add occupants (lights + AC turn ON)
status	status	Show room usage, booking, and devices
exit	exit	Exit the app
📊 Sample Run
Welcome to Smart Office App!
Commands (examples):
  config room count <n>
  config room maxcapacity <roomId> <capacity>
  book <roomId> <HH:MM> <minutes>
  cancel <roomId>
  add occupant <roomId> <count>
  status
  exit

> config room count 3
Office configured with 3 meeting rooms:
Room 1
Room 2
Room 3

> config room maxcapacity 1 10
Room 1 capacity set to 10 persons.

> book 1 09:00 60
Room 1 booked from 09:00 for 60 minutes.

> add occupant 1 8
Room 1 is now occupied by 8 persons. AC and lights turned on.

> status
Room 1 | occupants=8 | booking=Room 1 booked 09:00 for 60 min (ends 10:00)
Room 2 | occupants=0 | booking=None
Room 3 | occupants=0 | booking=None

⚠️ Known Issue

Currently, the end-time calculation may be off for some durations (e.g., book 3 07:00 240 shows incorrect end time).
This happens due to time parsing/formatting in the Booking class.

✅ Features Highlight

Command Pattern → Encapsulates user commands like book, cancel.

Observer Pattern → Lights & AC auto-switch when occupants are added.

Singleton → Centralized OfficeConfig ensures only one office instance.