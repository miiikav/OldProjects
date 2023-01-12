extends KinematicBody2D

onready var crosshairs:Node2D  = get_node("Crosshairs")
onready var camera:Camera2D    = get_node("Camera2D")

export var rot_amount = deg2rad(10)
export var cursor_radius = 200

var cross_hairs_angle = 0

func _ready():
	move_crosshairs_to_angle(cross_hairs_angle)

func _input(event: InputEvent):
	var center:Vector2 = global_position
	Game.DebugInfo.set_center_pos(center)

	if event is InputEventMouseMotion:
		Game.DebugInfo.set_mouse_position_label(event.global_position)
		var diff:Vector2 = event.global_position - center
		var rad:float = diff.angle() + camera.rotation
		cross_hairs_angle = rad
		move_crosshairs_to_angle(cross_hairs_angle)
		return

func _process(delta):
	if Input.is_action_pressed("rot_left"):
		camera.rotation   -= rot_amount
		cross_hairs_angle -= rot_amount
		move_crosshairs_to_angle(cross_hairs_angle)
	elif Input.is_action_pressed("rot_right"):
		camera.rotation   += rot_amount
		cross_hairs_angle += rot_amount
		move_crosshairs_to_angle(cross_hairs_angle)

func move_crosshairs_to_angle(rad:float):
	# Not sure why this additional 75 is needed. If it's not here, the cursor is
	# centered left of the player's blue square

	# Also, as the camera is rotated, the effect does not work anymore. It seems the
	# center is shifted.
	var crosshair_x = (cursor_radius * cos(rad)) + 75
	var crosshair_y = (cursor_radius * sin(rad))
	crosshairs.position = Vector2(crosshair_x, crosshair_y)
	Game.DebugInfo.set_cursor_position_label(Vector2(crosshair_x, crosshair_y), rad)
