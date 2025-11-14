from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/soma', methods=['GET'])
def soma():
    num1 = float(request.args.get('num1'))
    num2 = float(request.args.get('num2'))
    resultado = num1 + num2
    return jsonify({'resultado': resultado})

@app.route('/subtracao', methods=['GET'])
def subtracao():
    num1 = float(request.args.get('num1'))
    num2 = float(request.args.get('num2'))
    resultado = num1 - num2
    return jsonify({'resultado': resultado})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)