extends Node

var DebugInfo = null
onready var camera_position_label:Label = get_tree().get_root().get_node("World/CanvasLayer/Camera Pos")
onready var cursor_position_label:Label = get_tree().get_root().get_node("World/CanvasLayer/Cursor Pos")
onready var mouse_position_label:Label = get_tree().get_root().get_node("World/CanvasLayer/Mouse Pos")
onready var center_pos:ColorRect = get_tree().get_root().get_node("World/CanvasLayer/CenterPos")

func _ready():
	DebugInfo = Debug.new(camera_position_label, cursor_position_label, mouse_position_label, center_pos)

class Debug:
	var camera_position_label:Label
	var mouse_position_label:Label
	var cursor_position_label:Label
	var center_pos:ColorRect

	func _init(camera_pos, cursor_pos, mouse_pos, center_box):
		camera_position_label = camera_pos
		mouse_position_label = mouse_pos
		cursor_position_label = cursor_pos
		center_pos = center_box

	func set_camera_position_label(pos:Vector2):
		camera_position_label.text = "Camera Pos: " + str(pos.x) + "," + str(pos.y)

	func set_mouse_position_label(pos:Vector2):
		mouse_position_label.text = "Mouse Pos: " + str(pos.x) + "," + str(pos.y)

	func set_cursor_position_label(pos:Vector2, angle):
		cursor_position_label.text = "Cursor Pos: " + str(pos.x) + "," + str(pos.y) + "\nAngle: " + str(angle)

	func set_center_pos(pos:Vector2):
		set_camera_position_label(pos)
		center_pos.rect_position = pos
