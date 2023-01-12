extends Area2D


# Declare member variables here. Examples:
# var a = 2
# var b = "text"

func _on_Area2D_area_entered(area):
	print("Level Change")
	get_node("/root/global").goto_scene("res://Level2.tscn")
func _on_body_entered(body):
	print("Level Change")
	if body.get_name() == "Player":
		#emit_signal("goto_scene")
		get_node("/root/global").goto_scene("res://Level2.tscn")
# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
