##extends Panel

##var cursor_set_to = 0
	
##func _ready():
##	set_process_input(true)

##func _input(event):

	## if statement depending on your version of Godot goes here : 
	# ------------------------------------------------------------

	## for 3.0 alpha -- uncomment this if
	##if( event is InputEventMouseButton and event.is_pressed() ):
		##cursor_set_to = 3
		## if cursor_set_to > 16 :
			## cursor_set_to = 0

		##set_default_cursor_shape(cursor_set_to)


		##if cursor_set_to == Control.CURSOR_ARROW :
			##print( "CURSOR_ARROW = 0" )
		##if cursor_set_to == Control.CURSOR_IBEAM :
			##print( "CURSOR_IBEAM = 1" )
		##if cursor_set_to == Control.CURSOR_POINTING_HAND :
			##print( "CURSOR_POINTING_HAND = 2" )
		##if cursor_set_to == Control.CURSOR_CROSS :
			##print( "CURSOR_CROSS = 3" )
		##if cursor_set_to == Control.CURSOR_WAIT :
			##print( "CURSOR_WAIT = 4" )
		##if cursor_set_to == Control.CURSOR_BUSY :
			##print( "CURSOR_BUSY = 5" )
		##if cursor_set_to == Control.CURSOR_DRAG :
			##print( "CURSOR_DRAG = 6" )
		##if cursor_set_to == Control.CURSOR_CAN_DROP :
			##print( "CURSOR_CAN_DROP = 7" )
		##if cursor_set_to == Control.CURSOR_FORBIDDEN :
			##print( "CURSOR_FORBIDDEN = 8" )
		##if cursor_set_to == Control.CURSOR_VSIZE :
			##print( "CURSOR_VSIZE = 9" )
		##if cursor_set_to == Control.CURSOR_HSIZE :
			##print( "CURSOR_HSIZE = 10" )
		##if cursor_set_to == Control.CURSOR_BDIAGSIZE :
			##print( "CURSOR_BDIAGSIZE = 11" )
		##if cursor_set_to == Control.CURSOR_FDIAGSIZE :
			##print( "CURSOR_FDIAGSIZE = 12" )
		##if cursor_set_to == Control.CURSOR_MOVE :
			##print( "CURSOR_MOVE = 13" )
		##if cursor_set_to == Control.CURSOR_VSPLIT :
			##print( "CURSOR_VSPLIT = 14" )
		##if cursor_set_to == Control.CURSOR_HSPLIT :
			##print( "CURSOR_HSPLIT = 15" )
		##if cursor_set_to == Control.CURSOR_HELP :
			##print( "CURSOR_HELP = 16" )
																								#Legal: CCzero
