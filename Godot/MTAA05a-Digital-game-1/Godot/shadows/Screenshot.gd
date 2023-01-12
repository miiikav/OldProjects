extends Panel


# Declare member variables here. Examples:
# var a = 2
# var b = "text"
func _ready():
	set_process_input(true)

func _input(event):

	## if statement depending on your version of Godot goes here : 
	# ------------------------------------------------------------

	## for 3.0 alpha -- uncomment this if
	if( event is InputEventMouseButton and event.is_pressed() ):
			#if Input.is_key_pressed(KEY_K):
				# start screen capture
				var image = get_viewport().get_texture().get_data()
				image.flip_y()
				image.save_png("C:/Users/tuomo/OneDrive - TUNI.fi/_Godot/new/screenshot.png")
				print( "screenshot_test" )
